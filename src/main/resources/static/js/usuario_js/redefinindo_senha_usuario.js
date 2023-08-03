function exibirPassword() {
  var confirmPasswordInput = document.getElementById("confirmPassword");
    var passwordInput = document.getElementById("password");
    if (passwordInput.type === "password") {
      passwordInput.type = "text";
      confirmPasswordInput.type = "text"
    } else {
      passwordInput.type = "password";
      confirmPasswordInput.type = "password"
    }
  }