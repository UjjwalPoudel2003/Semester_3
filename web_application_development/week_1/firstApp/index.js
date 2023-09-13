// let http = require('http');

// http.createServer((request, response) => {
//     response.writeHead(200, { 'Content-Type': 'text/html' });
//     response.write("<h1>Hello World!</h1>");
//     response.end();
// }).listen(3000, () => console.log("Server is running on port 3000"));

const connect = require('connect');
const app = connect();

const log = (request, response, next) => {
    console.log(request.url);
    next();
}

const helloFunction = (request, response, next) => {
    response.setHeader('Content-Type', 'text/html');
    response.end("<h1>Hello World!</h1>");
}

const byeFunction = (request, response, next) => {
    response.setHeader('Content-Type', 'text/html');
    response.end("<h1>bye World!</h1>");
}

app.use(log);
app.use('/hello', helloFunction);
app.use('/bye', byeFunction);

app.listen(3000, () => console.log("Server is running on port 3000"));