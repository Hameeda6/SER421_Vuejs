const express = require('express');
const app = express();

const port = 8888;

app.get('/', (req, res) => {
    res.send("IP ADDRESS REACHED");
});

app.get('/add', (req, res) => {
    let num1 = parseInt(req.query.num1);
    let num2 = parseInt(req.query.num2);
    let answer = num1 + num2;
    if(!answer){
        res.send("One of the inputs was not an integer!");
    } else {
        res.send("The answer: " + answer);
    }
});

app.listen(port, () =>{
    console.log("Server running on port " + port);
});