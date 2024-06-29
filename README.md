# NASA Mars Photos Viewer

## Descripción

Este proyecto es una aplicación de Java que consume la API de NASA para obtener y mostrar fotos tomadas por el rover Curiosity en Marte. La aplicación proporciona una interfaz gráfica que permite filtrar las fotos por cámara, rover y sol (día marciano). 

## Características

- **Filtrado de fotos**: Filtra las fotos por cámara, rover y sol.
- **Visualización de imágenes**: Muestra miniaturas de las fotos y permite abrirlas en una ventana independiente.
- **Interfaz gráfica de usuario**: Utiliza Swing para la interfaz gráfica.

## Uso
- **Al iniciar la aplicación, verás una ventana con opciones para seleccionar la cámara, el rover y el sol.
- **Selecciona los filtros deseados y haz clic en "Search".
- **Las fotos obtenidas se mostrarán en la parte inferior de la ventana.
- **Haz clic en los enlaces de las fotos para abrirlas en tu navegador o en la ventana independiente de visualización de imágenes.

## Estructura del Proyecto
- **Paquete uce.edu.ec.container
Controller: Controlador principal que maneja la interacción con la interfaz gráfica y el servicio de la API.

- **Paquete uce.edu.ec.main
Main: Clase principal que inicia la aplicación Spring Boot.

- **Paquete uce.edu.ec.model
Camera: Clase que representa una cámara del rover.

Photo: Clase que representa una foto tomada por el rover.

Rover: Clase que representa un rover.

- **Paquete uce.edu.ec.service
ApiService: Servicio que consume la API de NASA y filtra las fotos según los parámetros proporcionados.

- **Paquete uce.edu.ec.view
Window: Clase que define la ventana principal de la aplicación.
ImageViewer: Clase que define la ventana de visualización de imágenes.
