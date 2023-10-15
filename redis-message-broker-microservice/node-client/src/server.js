import {createClient} from 'redis'
import {v4} from 'uuid'
import {config} from 'dotenv'

config()

// Redis connection
let redisHost = process.env.REDIS_HOST || 'localhost';
console.log(`Resolved Redis host ${redisHost}`)
const client = createClient({
    url: `redis://${redisHost}:6379`
});
const connection = async () => await client.connect()

const NEWS_TOPIC = "updates";

const bodyGen = (length) => {
    let result = '';
    const characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    const charactersLength = characters.length;
    let counter = 0;
    while (counter < length) {
        result += characters.charAt(Math.floor(Math.random() * charactersLength));
        counter += 1;
    }
    return result;
}

const generateMessage = () => {
    let message = {
        'id': v4(),
        'body': bodyGen(50)
    };
    return message
}

connection().then((value) => {
    setInterval(() => {
        let message = generateMessage();
        client.lPush(NEWS_TOPIC, JSON.stringify(message)).then(() => {
            console.log(message)
            client.publish(NEWS_TOPIC, message.id).then(() => console.log("publish ", message.id))
        })
    }, 1000)
})
