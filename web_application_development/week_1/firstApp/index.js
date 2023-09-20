// let http = require('http');

// http.createServer((request, response) => {
//     response.writeHead(200, { 'Content-Type': 'text/html' });
//     response.write("<h1>Hello World!</h1>");
//     response.end();
// }).listen(3000, () => console.log("Server is running on port 3000"));

// const connect = require('connect');
const express = require('express');
// const app = connect();
const app = express();

// Purpose of the middleware is to create route
app.use('/', (request, response) => {
    response.send('hello world');
});

app.listen(8081);

// const log = (request, response, next) => {
//     console.log(request.url);
//     next();
// }

// const helloFunction = (request, response, next) => {
//     response.setHeader('Content-Type', 'text/html');
//     response.end("<h1>Hello World!</h1>");
// }

// const byeFunction = (request, response, next) => {
//     response.setHeader('Content-Type', 'text/html');
//     response.end("<h1>bye World!</h1>");
// }

// // Home page for the website
// const homePage = (request, response, next) => {
//     response.setHeader('Content-Type', 'text/html');
//     response.end("<h1>Home Page</h1>");
// }

// app.use(log);
// app.use('/hello', helloFunction);
// app.use('/bye', byeFunction);

// app.listen(3000, () => console.log("Server is running on port 3000"));