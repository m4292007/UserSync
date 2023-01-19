const express = require('express')
const app = express()
const port = 80

app.get('/UserSync/uid', (req, res) => {
    const u_id = req.query.u_id
    res.cookie('b_id', u_id, { domain: 'admaru.net', maxAge: 31556926 })
    res.send(u_id)
})

app.get('/UserSync/sync', (req, res) => {
    res.redirect('https://cm-exchange.toast.com/bi/pixel?cm_mid=1330086872&toast_push') // Real DSP cookie generation endpoint
    // res.redirect('https://maru.admaru.com/UserSync/pixel') // mock DSP
})

app.get('/testdsp', (req, res) => {
    res.redirect('/UserSync/uid?p_id=1000&u_id=ZNDIFUA5V4UV69954E4OK5S2I')
})

app.listen(port, () => {
    console.log(`User sync service listening on port ${port}`)
})