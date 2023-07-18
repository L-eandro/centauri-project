function ocultar_servico() {

    var servico = document.getElementById("servico").value;
    var kg = document.getElementById("kg");
    var litro = document.getElementById("litro");
    var lugar = document.getElementById("lugar");
    var teste = document.getElementById("teste");

    if (servico === "frete") {
      litro.style.display = "block";
      kg.style.display = "none";
      lugar.style.display = "none";
      teste.style.display = "none";

    }

    else if (servico === "mudanca") {
        kg.style.display = "block";
        litro.style.display = "none";
        lugar.style.display = "none";
        teste.style.display = "none";
      }
      
      else if (servico === "viagem") {
        lugar.style.display = "block";
        litro.style.display = "none";
        kg.style.display = "none";
        teste.style.display = "none";
      }
      
      else {
        lugar.style.display = "none";
        litro.style.display = "none";
        kg.style.display = "none";
        teste.style.display = "block";
      }   

  };



  function buscarCepPartida() {

    const cepInput = document.querySelector("#cep");
    const logradouroInput = document.querySelector("#logradouro");
    const bairroInput = document.querySelector("#bairro");
    const cidadeInput = document.querySelector("#cidade");
    const complementoInput = document.querySelector("#complemento");
    
    //validação basica do cep
    cepInput.addEventListener("keypress", (e) => {
     
        const onlyNumber = /[0-9]/;
        //transformando e pegando oque foi digitado para string
        const key = String.fromCharCode(e.keyCode);
    
        //permitir apenas numeros
        if(!onlyNumber.test(key)){
            //so cai nesse if se o usuario digitar algo que não seja numerico
            e.preventDefault();
            return;
        }
    });
    
    cepInput.addEventListener("keyup" , (e) => {
        //pegando valor do input cep
        const inputValue = e.target.value;
    
        //verificar se tem a quantidade necessaria de digitos
        if(inputValue.length == 8){
            getEndereco(inputValue);
        }
    });
    
        //obtendo endereço do cliente da API
        const getEndereco = async (cep) =>{
    
        cepInput.blur();
        const apiUrl = `https://viacep.com.br/ws/${cep}/json/`
        const response = await fetch(apiUrl);
        const data = await response.json();   
    
        //mandando a função para habilitar os campos para editar
        toggleDisabled();
    
        //passados valores da api para as variaveis
        logradouroInput.value = data.logradouro
        cidadeInput.value = data.localidade
        bairroInput.value = data.bairro
        complementoInput.focus();
    };
    
    //função para habilitar os campos novamente para que o usuario consiga editar
    const toggleDisabled = () => {
    
        //verificando se realmente tem algum imput com a opção desabilitada
        if(logradouroInput.hasAttribute("disabled")){
          logradouroInput.removeAttribute("disabled");
            complementoInput.removeAttribute("disabled");
            cidadeInput.removeAttribute("disabled");
            bairroInput.removeAttribute("disabled");
            
    
     }else {
            //se precisar adicionar desable novamente
          logradouroInput.setAttribute("desabled","desabled");
        complementoInput.setAttribute("desabled","desabled");
        cidadeInput.setAttribute("desabled","desabled");
        bairroInput.setAttribute("desabled","desabled");
                
    }};
    }


    function buscarCepChegada(){

    const cepInput = document.querySelector("#cep-chegada");
    const logradouroInput = document.querySelector("#logradouro-chegada");
    const bairroInput = document.querySelector("#bairro-chegada");
    const cidadeInput = document.querySelector("#cidade-chegada");
    const complementoInput = document.querySelector("#complemento-chegada");
 
    
    
    //validação basica do cep
    cepInput.addEventListener("keypress", (e) => {
     
        const onlyNumber = /[0-9]/;
        //transformando e pegando oque foi digitado para string
        const key = String.fromCharCode(e.keyCode);
    
        //permitir apenas numeros
        if(!onlyNumber.test(key)){
            //so cai nesse if se o usuario digitar algo que não seja numerico
            e.preventDefault();
            return;
        }
    });
    
    cepInput.addEventListener("keyup" , (e) => {
        //pegando valor do input cep
        const inputValue = e.target.value;
    
        //verificar se tem a quantidade necessaria de digitos
        if(inputValue.length == 8){
            getEndereco(inputValue);
        }
    });
    
        //obtendo endereço do cliente da API
        const getEndereco = async (cep) =>{
    
        cepInput.blur();
        const apiUrl = `https://viacep.com.br/ws/${cep}/json/`
        const response = await fetch(apiUrl);
        const data = await response.json();   
    
        //mandando a função para habilitar os campos para editar
        toggleDisabled();
    
        //passados valores da api para as variaveis
        logradouroInput.value = data.logradouro
        cidadeInput.value = data.localidade
        bairroInput.value = data.bairro
        complementoInput.focus();
    };
    
    //função para habilitar os campos novamente para que o usuario consiga editar
    const toggleDisabled = () => {
    
        //verificando se realmente tem algum imput com a opção desabilitada
        if(logradouroInput.hasAttribute("disabled")){
          logradouroInput.removeAttribute("disabled");
            complementoInput.removeAttribute("disabled");
            cidadeInput.removeAttribute("disabled");
            bairroInput.removeAttribute("disabled");       
    
     }else {
            //se precisar adicionar desable novamente
          logradouroInput.setAttribute("desabled","desabled");
        complementoInput.setAttribute("desabled","desabled");
        cidadeInput.setAttribute("desabled","desabled");
        bairroInput.setAttribute("desabled","desabled");         
    }};
  }
   



  