package com.example.Groovy

def sayHello(params) {
    params.result = "Hello, " + params.name + "! You are " + params.age + " years old."
}