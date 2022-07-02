document.querySelector('#check-password').addEventListener('click', function() {
    if (document.querySelector('#password-input').value == "test") {
        window.location.replace("main.html");
    } else {
        document.querySelector('#incorrect-message').style.display = "block";
    }
})