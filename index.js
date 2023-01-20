const express = require('express')
const cors = require('cors')
const https = require('https')
const http = require('http')
const fs = require('fs')
require('dotenv').config()

const app = express()

app.use(
    cors({
        origin: true,
        credentials: true,
    })
);

app.get('/UserSync/uid', (req, res) => {
    const u_id = req.query.u_id
    res.cookie('b_id', u_id, { domain: 'admaru.net', maxAge: 31556926000, secure: true, sameSite: 'none' })
    res.send(u_id)
})

app.get('/UserSync/sync', (req, res) => {
    res.redirect('https://cm-exchange.toast.com/bi/pixel?cm_mid=1330086872&toast_push') // Real DSP cookie generation endpoint
    // res.redirect('https://maru.admaru.com/UserSync/pixel') // mock DSP
})

app.get('/testdsp', (req, res) => {
    res.redirect('/UserSync/uid?p_id=1000&u_id=ZNDIFUA5V4UV69954E4OK5S2I')
})

http.createServer(app).listen(80, () => {
    console.log(`User sync service listening on port 80`)
})

if (process.env.HTTPS_CERT_PATH) {
    const httpsOptions = {
        key: fs.readFileSync(`${process.env.HTTPS_CERT_PATH}/privkey.pem`),
        cert: fs.readFileSync(`${process.env.HTTPS_CERT_PATH}/cert.pem`),
        ca: fs.readFileSync(`${process.env.HTTPS_CERT_PATH}/chain.pem`)
    }

    https.createServer(httpsOptions, app).listen(443, () => {
        console.log(`User sync service listening on port 443`)
    })
}
