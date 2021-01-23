const http = require('http')
const app = require('./configurations/express')

http.createServer(app).listen(3000, function () {
    console.log(`[Card Application - ${(new Date()).toISOString()}] The server is running on port: ${this.address().port}`)
})