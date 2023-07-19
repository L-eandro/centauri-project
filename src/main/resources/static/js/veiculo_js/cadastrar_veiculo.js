function ocultar_servico() {
    var selectElement = document.getElementById("veiculo");
    var selectedOption = selectElement.value;

    var mudanca =  document.getElementById("mudanca");
    var frete =  document.getElementById("frete");
    var viagem =  document.getElementById("viagem");

    var kg = document.getElementById("kg");
    var litro = document.getElementById("litro");
    var lugar = document.getElementById("lugar");
    var teste = document.getElementById("teste");

    if(selectedOption === "caminhao"){
        mudanca.selected = true;

        kg.style.display = "block";
        litro.style.display = "none";
        lugar.style.display = "none";
        teste.style.display = "none";


    }else if(selectedOption === "caminhonete"){
        frete.selected = true;
        
        kg.style.display = "none";
        litro.style.display = "block";
        lugar.style.display = "none";
        teste.style.display = "none";

    }
    else if(selectedOption === "carro" || selectedOption === "kombi" || selectedOption === "van" || selectedOption === "onibus")
    {
        viagem.selected = true;

        kg.style.display = "none";
        litro.style.display = "none";
        lugar.style.display = "block";
        teste.style.display = "none";


    }
    else if(selectedOption === ""){
        viagem.selected = false;
        frete.selected = false;
        mudanca.selected = false;
        kg.style.display = "none";
        litro.style.display = "none";
        lugar.style.display = "none";
        teste.style.display = "block";
        teste.disabled=true;



    }



   
    


  }
