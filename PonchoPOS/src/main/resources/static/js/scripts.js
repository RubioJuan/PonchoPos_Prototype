const apiURL = 'http://localhost:8080/api/categorias'; 

// Función para obtener y mostrar categorías
function fetchCategorias() {
    fetch(apiURL)
        .then(response => response.json())
        .then(data => {
            const categoriasDiv = document.getElementById('categorias');
            categoriasDiv.innerHTML = ''; // Limpiar el contenido
            data.forEach(categoria => {
                const div = document.createElement('div');
                div.classList.add('category-item');
                div.innerHTML = `
                    <span>${categoria.nombre} - ${categoria.descripcion}</span>
                    <div>
                        <button onclick="editCategoria(${categoria.id_categoria})">Editar</button>
                        <button onclick="deleteCategoria(${categoria.id_categoria})">Eliminar</button>
                    </div>
                `;
                categoriasDiv.appendChild(div);
            });
        })
        .catch(error => console.error('Error:', error));
}

// Función para manejar el envío del formulario
document.getElementById('categoriaForm').addEventListener('submit', function(e) {
    e.preventDefault(); // Prevenir el comportamiento por defecto del formulario

    const id = document.getElementById('categoriaId').value;
    const nombre = document.getElementById('nombre').value;
    const descripcion = document.getElementById('descripcion').value;

    if (id) {
        // Actualizar
        fetch(`${apiURL}/actualizar/${id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nombre, descripcion })
        })
        .then(response => {
            if (!response.ok) throw new Error('Error al actualizar la categoría');
            return response.json();
        })
        .then(data => {
            console.log('Categoría actualizada:', data);
            fetchCategorias(); // Refrescar la lista
            clearForm(); // Limpiar el formulario
        })
        .catch(error => console.error('Error:', error));
    } else {
        // Crear nueva categoría
        fetch(`${apiURL}/guardar`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({ nombre, descripcion })
        })
        .then(response => {
            if (!response.ok) throw new Error('Error al guardar la categoría');
            return response.json();
        })
        .then(data => {
            console.log('Categoría creada:', data);
            fetchCategorias(); // Refrescar la lista
            clearForm(); // Limpiar el formulario
        })
        .catch(error => console.error('Error:', error));
    }
});

// Función para editar una categoría
function editCategoria(id) {
    fetch(`${apiURL}/${id}`)
        .then(response => response.json())
        .then(categoria => {
            document.getElementById('categoriaId').value = categoria.id_categoria;
            document.getElementById('nombre').value = categoria.nombre;
            document.getElementById('descripcion').value = categoria.descripcion;
        })
        .catch(error => console.error('Error:', error));
}

// Función para eliminar una categoría
function deleteCategoria(id) {
    fetch(`${apiURL}/eliminar/${id}`, {
        method: 'DELETE'
    })
    .then(() => {
        console.log('Categoría eliminada');
        fetchCategorias(); // Refrescar la lista
    })
    .catch(error => console.error('Error:', error));
}

// Función para limpiar el formulario
function clearForm() {
    document.getElementById('categoriaId').value = '';
    document.getElementById('nombre').value = '';
    document.getElementById('descripcion').value = '';
}

// Obtener categorías al cargar la página
window.onload = fetchCategorias;
