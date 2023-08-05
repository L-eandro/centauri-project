
      
     function enviarFormularioWhatsApp() {

    const dataServico = document.getElementById("data").value;
    const horario = document.getElementById("hora").value;
    const valor = document.getElementById("valor").value;

//------------------------------------------------------------------------------
    const cep = document.getElementById("cep").value;
    const logradouro = document.getElementById("logradouro").value;
    const bairro =  document.getElementById("bairro").value;
    const localidade = document.getElementById("cidade").value;
    const complemento = document.getElementById("complemento").value;

//------------------------------------------------------------------------------
    const cep2 = document.getElementById("cep2").value;
    const logradouro2 = document.getElementById("logradouro2").value;
    const bairro2 =  document.getElementById("bairro2").value;
    const localidade2 = document.getElementById("cidade2").value;
    const complemento2 = document.getElementById("complemento2").value;
//------------------------------------------------------------------------------

    const resultado = document.getElementById("resultado").value;
    const nomeMotorista = document.getElementById("nome").value;
    const veiculo = document.getElementById("veiculo").value;
    const servico = document.getElementById("servico").value;
    const capacidade = document.getElementById("capacidade").value;

//------------------------------------------------------------------------------
    const dataAtual = new Date();
    const dataInserida = new Date(dataServico);
    if (dataInserida <= dataAtual) {
      alert("A data do serviço deve ser posterior à data atual.");
      //const mensagemErroData= document.querySelector("#mensagemErroData").innerText="A data do serviço deve ser posterior à data atual.";
      dataServico.focus();
      return; // Impede o envio do formulário caso a data seja inválida
    }

  


 const mensagem = `
  Data do Serviço: ${dataServico}
  Horário: ${horario}
  Valor Ofertado: ${valor}
  Endereço de Partida:
  CEP: ${cep}
  Logradouro: ${logradouro}
  Bairro: ${bairro}
  Cidade: ${localidade}
  Numero/Complemento/Referência: ${complemento || ""}
  Endereço de Chegada:
  CEP: ${cep2}
  Logradouro: ${logradouro2}
  Bairro: ${bairro2}
  Cidade: ${localidade2}
  Numero/Complemento/Referência: ${complemento2 || ""}
  Distancia Total: ${resultado}
  Informações do Motorista/Veículo:
  Nome Motorista: ${nomeMotorista}
  Veículo: ${veiculo}
  Serviço: ${servico}
  Capacidade: ${capacidade}
  `;
  
        

        const numeroTelefone = '5581986192476';
        const encodedMessage = encodeURIComponent(mensagem);
        const whatsappURL = `https://wa.me/${numeroTelefone}/?text=${encodedMessage}`;
  
        // Redirecionar para o link do WhatsApp
        window.open(whatsappURL, "_blank");
      }

/*
 
      // Adicionar o evento de submit ao formulário
      const formularioWhatsApp = document.getElementById("solicitacao-form");
      formularioWhatsApp.addEventListener("submit", function (event) {
        event.preventDefault();
        enviarFormularioWhatsApp();
        
      }
      );*/


    


