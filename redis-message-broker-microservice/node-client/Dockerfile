FROM node:18-alpine

# Create app directory
WORKDIR /usr/src/app

COPY package*.json ./
RUN npm install

COPY ./src .
RUN touch .env
RUN echo REDIS_HOST=redis >> .env

EXPOSE 8080

CMD [ "node", "server.js" ]