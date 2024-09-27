document.addEventListener("DOMContentLoaded", function() {
    // Selecciona el formulario y los botones
    const form = document.getElementById("inventarioForm");
    const submitButton = form.querySelector("button[type='submit']");

    // Función para animar el formulario
    function toggleFormAnimation() {
        form.classList.add("animate__animated", "animate__fadeIn");
        setTimeout(() => {
            form.classList.remove("animate__animated", "animate__fadeIn");
        }, 1000); // Duración de la animación
    }

    // Ejecutar la animación al cargar el formulario
    toggleFormAnimation();

    // Agregar efecto hover a los botones
    const buttons = document.querySelectorAll("button, .edit-btn, .delete-btn");
    buttons.forEach(button => {
        button.addEventListener("mouseover", function() {
            this.style.transform = "scale(1.05)";
            this.style.transition = "transform 0.2s";
        });
        button.addEventListener("mouseout", function() {
            this.style.transform = "scale(1)";
        });
    });
});
