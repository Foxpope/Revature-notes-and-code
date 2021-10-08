//ajax, fetch

//capture the elements we need to grab data from
let pokeId = document.getElementById('poke-id')
let pokemonName = document.getElementById('name')
let renderedId = document.getElementById('id')
let btn = document.getElementById('btn')

btn.addEventListener("click", ajaxCall)

function ajaxCall() {
    
    
    let idNum = pokeId.value;

    let xhr = new XMLHttpRequest();

    xhr.onreadystatechange = function() {

        //check that th ready state is done andthat the status is 200
        if (this.readyState == 4 && this.status == 200) {
            //grab data
            let recievedPokemon = JSON.parse(xhr.responseText)

            console.log(recievedPokemon)

            renderHTML(recievedPokemon)
        }
        
    }

    xhr.open("GET", `https://pokeapi.co/api/v2/pokemon/${idNum}`)

    xhr.send()

    function renderHTML(data) {

        pokemonName.innerHTML = "Name: " + data.name;
        renderedId.innerHTML = "ID: " + data.id;

        let image = document.getElementById('sprite')
        image.setAttribute("src", data.sprites.front_default)

        image.setAttribute("height", 300)

    }

}