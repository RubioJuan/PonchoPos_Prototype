document.getElementById('clienteForm').addEventListener('submit', function(event) {
    const documento = document.getElementById('documento').value;
    const nombre = document.getElementById('nombre').value;
    const apellido = document.getElementById('apellido').value;

    if (!documento || !nombre || !apellido) {
        alert("Por favor, complete todos los campos requeridos.");
        event.preventDefault(); // Evitar el envío del formulario si hay campos vacíos
    }
});