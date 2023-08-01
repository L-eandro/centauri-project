function ocultar_servicoo() {

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
    
    //validação basica do cep para ser digitado so numeros
    //quando precionar a tecla vai ser ativado a função
    cepInput.addEventListener("keypress", (e) => {
     
     // limitando apenas numero de 0 a 9 digitados
        const onlyNumber = /[0-9]/;

        //transformando e pegando oque foi digitado para string para obter o valor exato digitado pelo usuario
        const key = String.fromCharCode(e.keyCode);
    
        //permitir apenas numeros
        if(!onlyNumber.test(key)){
            //so cai nesse if se o usuario digitar algo que não seja numerico
            e.preventDefault();
            return;
        }
    });
    

    //pegando os valores quando termina de digitar o 8 digito
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
    
        //removendo o foco do campo cep, 
        cepInput.blur();

        //Url da api do cep, passando para variavel apiUrl
        const apiUrl = `https://viacep.com.br/ws/${cep}/json/`

        //usando a função fetch para uma requisição e await para aguardar a requisição ser concluida e adicionar na variavel response
        const response = await fetch(apiUrl);

        //resposta da requisição convertida em formato JSON e guardado na vaiavel data.
        const data = await response.json(); 
       
        //verificando se a busca do cep obteve algum error
        if(data.erro){
          const mensagemErro= document.querySelector("#mensagemErro").innerText="CEP não encontrado. Por favor, verifique o CEP digitado.";
        document.getElementById("logradouro").value = "";
        document.getElementById("bairro").value = "";
        document.getElementById("cidade").value = "";
          return;
        }else{
          //apagando a mensagem de error da tela
          mensagemErro= document.querySelector("#mensagemErro").innerText="";
        //mandando a função para habilitar os campos para editar
        toggleDisabled();
        //passados valores da api para as variaveis
        logradouroInput.value = data.logradouro
        cidadeInput.value = data.localidade
        bairroInput.value = data.bairro
        complementoInput.focus();
      }
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


//--------------------------------------------------------------------------------



    function buscarCepChegada(){

    const cep2Input = document.querySelector("#cep2");
    const logradouro2Input = document.querySelector("#logradouro2");
    const bairro2Input = document.querySelector("#bairro2");
    const cidade2Input = document.querySelector("#cidade2");
    const complemento2Input = document.querySelector("#complemento2");
 
    
      //validação basica do cep para ser digitado so numeros
    //quando precionar a tecla vai ser ativado a função
    cep2Input.addEventListener("keypress", (e) => {
     
      // limitando apenas numero de 0 a 9 digitados
         const onlyNumber = /[0-9]/;
 
         //transformando e pegando oque foi digitado para string para obter o valor exato digitado pelo usuario
         const key = String.fromCharCode(e.keyCode);
     
         //permitir apenas numeros
         if(!onlyNumber.test(key)){
             //so cai nesse if se o usuario digitar algo que não seja numerico
             e.preventDefault();
             return;
         }
     });
     
 
     //pegando os valores quando termina de digitar o 8 digito
     cep2Input.addEventListener("keyup" , (e) => {
         //pegando valor do input cep
         const inputValue = e.target.value;
     
         //verificar se tem a quantidade necessaria de digitos
         if(inputValue.length == 8){
             getEndereco(inputValue);
         }
     });
     
         //obtendo endereço do cliente da API
         const getEndereco = async (cep) =>{
     
         //removendo o foco do campo cep, para o usuario não ficar digitando enquanto buscar o cep
         cep2Input.blur();
 
         //Url da api do cep, passando para variavel apiUrl
         const apiUrl = `https://viacep.com.br/ws/${cep}/json/`
 
         //usando a função fetch para uma requisição e await para aguardar a requisição ser concluida e adicionar na variavel response
         const response = await fetch(apiUrl);
 
         //resposta da requisição convertida em formato JSON e guardado na vaiavel data.
         const data = await response.json(); 
        
         //verificando se a busca do cep obteve algum error
         if(data.erro){
           const mensagemErro2= document.querySelector("#mensagemErro2").innerText="CEP não encontrado. Por favor, verifique o CEP digitado.";
        document.getElementById("resultado").value=""
         document.getElementById("logradouro2").value = "";
         document.getElementById("bairro2").value = "";
         document.getElementById("cidade2").value = "";
           return;
         }else{
           //apagando a mensagem de error da tela
           mensagemErro2= document.querySelector("#mensagemErro2").innerText="";
         //mandando a função para habilitar os campos para editar
         toggleDisabled();
         //passados valores da api para as variaveis
         logradouro2Input.value = data.logradouro
         cidade2Input.value = data.localidade
         bairro2Input.value = data.bairro
         complemento2Input.focus();
       }
     };
     
     //função para habilitar os campos novamente para que o usuario consiga editar
     const toggleDisabled = () => {
     
         //verificando se realmente tem algum imput com a opção desabilitada
         if(logradouro2Input.hasAttribute("disabled")){
             logradouro2Input.removeAttribute("disabled");
             complemento2Input.removeAttribute("disabled");
             cidade2Input.removeAttribute("disabled");
             bairro2Input.removeAttribute("disabled");      
     
      }else {
             //se precisar adicionar desable novamente
         logradouro2Input.setAttribute("desabled","desabled");
         complemento2Input.setAttribute("desabled","desabled");
         cidade2Input.setAttribute("desabled","desabled");
         bairro2Input.setAttribute("desabled","desabled");           
     }};
    
  }
   

