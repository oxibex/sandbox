FROM node:18-alpine

# Create app directory
WORKDIR /usr/src/app

COPY package*.json ./
RUN npm install

COPY ./src .

EXPOSE 8080

CMD [ "node", "server.js" ]