// Función para confirmar la eliminación de un producto
function confirmDelete() {
    return confirm("¿Estás seguro de que deseas eliminar este producto?");
}

// Añadir evento de carga para agregar interactividad
document.addEventListener('DOMContentLoaded', function() {
    // Seleccionar todos los botones de eliminar y editar
    const deleteButtons = document.querySelectorAll('.delete-btn');
    const editButtons = document.querySelectorAll('.edit-btn');

    // Agregar eventos a los botones de eliminar
    deleteButtons.forEach(button => {
        button.addEventListener('click', function(event) {
            if (!confirmDelete()) {
                event.preventDefault(); // Cancelar la acción si no se confirma
            }
        });
    });

    // Añadir animación de hover a los botones de acción
    editButtons.forEach(button => {
        button.style.transition = 'background-color 0.3s ease';
        button.addEventListener('mouseover', function() {
            button.style.backgroundColor = '#0056b3'; // Cambiar a un tono más oscuro
        });
        button.addEventListener('mouseout', function() {
            button.style.backgroundColor = '#007bff'; // Volver al color original
        });
    });

    deleteButtons.forEach(button => {
        button.style.transition = 'background-color 0.3s ease';
        button.addEventListener('mouseover', function() {
            button.style.backgroundColor = '#c82333'; // Cambiar a un tono más oscuro
        });
        button.addEventListener('mouseout', function() {
            button.style.backgroundColor = '#dc3545'; // Volver al color original
        });
    });
});
