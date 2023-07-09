function ocultar_servico() {
    var selectElement = document.getElementById("servico");
    var selectedOption = selectElement.value;

    var caminhonete = document.getElementById("caminhonete");
    var caminhao = document.getElementById("caminhao");
    var carro = document.getElementById("carro");
    var kombi = document.getElementById("kombi");
    var van = document.getElementById("van");
    var onibus = document.getElementById("onibus");
    var kg = document.getElementById("kg");
    var litro = document.getElementById("litro");
    var lugar = document.getElementById("lugar");



    if (selectedOption === "frete") {
      caminhonete.style.display = "block";
      litro.style.display = "block";
    }else{
      caminhonete.style.display = "none";
      litro.style.display = "none";
    }

    if(selectedOption === "mudanca") {
      caminhao.style.display = "block";
      kg.style.display = "block";

  }else {
    caminhao.style.display = "none";
    kg.style.display = "none";
    }

    if(selectedOption === "viagem") { 
      carro.style.display = "block";
      kombi.style.display = "block";
      van.style.display = "block";
      onibus.style.display = "block";
      lugar.style.display = "block";

  }else {
    carro.style.display = "none";
      kombi.style.display = "none";
      van.style.display = "none";
      onibus.style.display = "none";
      lugar.style.display = "none";
    }

    


  }
