const enderecoForm = document.querySelector("#endereco-form");
const cepInput = document.querySelector("#cep");
const ruaInput = document.querySelector("#rua");
const numeroInput = document.querySelector("#numero");
const complementoInput = document.querySelector("#complemento");
const bairroInput = document.querySelector("#bairro");
const cidadeInput = document.querySelector("#cidade");
const estadoInput = document.querySelector("#estado");
const formInputs = document.querySelector("[data-input]");


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
    ruaInput.value = data.logradouro
    cidadeInput.value = data.localidade
    bairroInput.value = data.bairro
    estadoInput.value = data.uf
    numeroInput.focus();
};

//função para habilitar os campos novamente para que o usuario consiga editar
const toggleDisabled = () => {

    //verificando se realmente tem algum imput com a opção desabilitada
    if(ruaInput.hasAttribute("disabled")){
        ruaInput.removeAttribute("disabled");
        numeroInput.removeAttribute("disabled");
        complementoInput.removeAttribute("disabled");
        cidadeInput.removeAttribute("disabled");
        bairroInput.removeAttribute("disabled");
        estadoInput.removeAttribute("disabled");

 }else {
        //se precisar adicionar desable novamente
    ruaInput.setAttribute("desabled","desabled");
    numeroInput.setAttribute("desabled","desabled");
    complementoInput.setAttribute("desabled","desabled");
    cidadeInput.setAttribute("desabled","desabled");
    bairroInput.setAttribute("desabled","desabled");
    estadoInput.setAttribute("desabled","desabled");
        
}

};


