function ocultar_servico() {
    const veiculoSelect = document.getElementById("veiculo");
    const servicoSelect = document.getElementById("servico");

    
    if (veiculoSelect.value === "CARRO" || veiculoSelect.value === "KOMBI" || veiculoSelect.value === "VAN" || veiculoSelect.value === "ONIBUS") {
        servicoSelect.value = "VIAGEM";
    } else if (veiculoSelect.value === "CAMINHONETE") {
        servicoSelect.value = "FRETE";
    } else if (veiculoSelect.value === "CAMINHAO") {
        servicoSelect.value = "MUDANCA";
    } else {
        // Caso contrário, deselecionar qualquer opção selecionada no segundo select
        servicoSelect.value = "";
    }

    // Habilitar ou desabilitar o segundo select com base na escolha do primeiro select
    servicoSelect.disabled = veiculoSelect.value === "";
}