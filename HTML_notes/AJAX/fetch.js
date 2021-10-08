window.onload = function () {
    console.log('fetch.js is loaded')

    //this is anaoutdated pattern (you shouldn't put code here)
    document.getElementById('btn').addEventListener("click", fetchCall)
}

function fetchCall() {
    let input = document.getElementById('poke-id').value

    fetch(`https://pokeapi.co/api/v2/pokemon/54`)
        .then((response) => response.json())
        .then((data) => {
            console.log(data)

            //set the src attribute for the img
            document.getElementById(sprite).src = data.sprites.front_default

        }, (error) => {
            console.error(`Error is: ${error}`)
        })
}