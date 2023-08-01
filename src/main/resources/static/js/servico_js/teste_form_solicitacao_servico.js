
async function buscarEnderecoPorCep(cep) {
    const apiUrl = `https://viacep.com.br/ws/${cep}/json/`;
    const response = await fetch(apiUrl);
    const data = await response.json();
    return data;
}

// Função para preencher o endereço de partida
function preencherEnderecoPartida(data) {
    const logradouroInput = document.getElementById("logradouro");
    const bairroInput = document.getElementById("bairro");
    const cidadeInput = document.getElementById("cidade");
    const complementoInput = document.getElementById("complemento");

    logradouroInput.value = data.logradouro;
    bairroInput.value = data.bairro;
    cidadeInput.value = data.localidade;
    complementoInput.focus();
}

// Função para preencher o endereço de chegada
function preencherEnderecoChegada(data) {
    const logradouroInput = document.getElementById("logradouro-chegada");
    const bairroInput = document.getElementById("bairro-chegada");
    const cidadeInput = document.getElementById("cidade-chegada");
    const complementoInput = document.getElementById("complemento-chegada");

    logradouroInput.value = data.logradouro;
    bairroInput.value = data.bairro;
    cidadeInput.value = data.localidade;
    complementoInput.focus();
}

// Função que será chamada quando o formulário for enviado
function enviarFormulario(event) {
    event.preventDefault();

    // Pegar os valores do formulário
    const dataServico = document.getElementById("data-servico").value;
    const horario = document.getElementById("horario").value;
    const valor = document.getElementById("valor").value;
    const cepPartida = document.getElementById("cep").value;
    const cepChegada = document.getElementById("cep-chegada").value;
    const nomeMotorista = document.getElementById("nome").value;
    const veiculo = document.getElementById("veiculo").value;
    const servico = document.getElementById("servico").value;

    // Buscar os endereços por CEP automaticamente
    Promise.all([buscarEnderecoPorCep(cepPartida), buscarEnderecoPorCep(cepChegada)])
        .then(([dataPartida, dataChegada]) => {
            preencherEnderecoPartida(dataPartida);
            preencherEnderecoChegada(dataChegada);

            // Construir a mensagem para o WhatsApp com os parâmetros
            const mensagem = `Data do Serviço: ${dataServico}
Horário: ${horario}
Valor: ${valor}
Endereço de Partida:
CEP: ${cepPartida}
Logradouro: ${dataPartida.logradouro}
Bairro: ${dataPartida.bairro}
Cidade: ${dataPartida.localidade}
Complemento/Referência: ${dataPartida.complemento || ""}
Endereço de Chegada:
CEP: ${cepChegada}
Logradouro: ${dataChegada.logradouro}
Bairro: ${dataChegada.bairro}
Cidade: ${dataChegada.localidade}
Complemento/Referência: ${dataChegada.complemento || ""}
Informações do Motorista/Veículo:
Nome Motorista: ${nomeMotorista}
Veículo: ${veiculo}
Serviço: ${servico}`;

            // Codificar a mensagem para usar no link do WhatsApp
            const numeroTelefone = '5581988742454';
            const encodedMessage = encodeURIComponent(mensagem);
            const whatsappURL = `https://wa.me/${numeroTelefone}/?text=${encodedMessage}`;

            // Redirecionar para o link do WhatsApp
            window.open(whatsappURL, "_blank");
        })
        .catch(error => {
            console.error("Erro ao buscar o endereço:", error);
        });
}

// Adicionar o evento de submit ao formulário
const formulario = document.getElementById("solicitacao-form");
formulario.addEventListener("submit", enviarFormulario);



