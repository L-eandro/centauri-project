

function calcularDistancia() {
    const cep1 = document.getElementById("cep").value;
    const cep2 = document.getElementById("cep2").value;
    const resultadoInput = document.getElementById("resultado");

    const geocoder = new google.maps.Geocoder();
    const geocoderPromises = [geocodeAddress(geocoder, cep1), geocodeAddress(geocoder, cep2)];

    Promise.all(geocoderPromises)
        .then(results => {
            const coords1 = results[0].geometry.location;
            const coords2 = results[1].geometry.location;

            const service = new google.maps.DistanceMatrixService();
            service.getDistanceMatrix(
                {
                    origins: [coords1],
                    destinations: [coords2],
                    travelMode: google.maps.TravelMode.DRIVING,
                },
                (response, status) => {
                    if (status === "OK") {
                        const distanciaKm = response.rows[0].elements[0].distance.value / 1000; // Distância em quilômetros
                        
                        if (distanciaKm >= 1) {
                            resultadoInput.value = `${distanciaKm.toFixed(2)} KM.`;
                        } else {
                            const distanciaMetros = distanciaKm * 1000; // Distância em metros
                            resultadoInput.value = `${distanciaMetros.toFixed(2)} Metros.`;
                        }
                    } else {
                        console.log("Ocorreu um erro ao calcular a distância:", status);
                        resultadoInput.value = `Erro ao calcular a distância, digite os ceps novamente`;
                    }
                }
            );
        })
        .catch(error => {
            console.log("Ocorreu um erro ao calcular a distância:", error);
            resultadoInput.value = `Erro ao calcular a distância, digite os ceps novamente`;
        });
}

function geocodeAddress(geocoder, address) {
    return new Promise((resolve, reject) => {
        geocoder.geocode({ address: address }, (results, status) => {
            if (status === "OK") {
                resolve(results[0]);
            } else {
                reject(status);
            }
        });
    });
}
// Adicionando evento de escuta (blur event) ao campo de entrada do segundo CEP
document.getElementById("cep2").addEventListener("blur", function() {
    calcularDistancia();
});




  