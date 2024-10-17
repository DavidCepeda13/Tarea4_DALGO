Para hacer uso de los algoritmos tiene que ingresar:
	args[0]: Ruta del archivo donde se encuentra el grafo. Dicho arhchivo debe contener la siguiente estructura:
		Cada linea contiene un eje, el cual se representa como "nodoInicio nodoDestino peso", cada item separado
		por espacios.
	args[1]: Ruta del archivo donde se guardará el resultado. El formato del archivo dependerá del programa ejecutado.
		Para el caso de los algorimos Dijkstra, Bellman Ford y Floyd Warshall, los archivos contendrán la matriz de 
		costos minimos. Por otro lado, el archivo del programa del BFS contendrá la lista de particiones, el 
		programa de las carreteras guardará en orden la lista de nodos que representan el caminos de las vias
		a expandir. Por último, el archivo del programa de flujo de redes guardará el máximo de libros  que se pueden 
		transportar por día.

Para iniciar el programa ejecute el main, se desplegará una lista de opciones, deberá digitar la opción de 
interés, si el archivo del grafo se encontraba en la estructura especificada los algoritmos harán su trabajo. Una vez
se ejecute el algoritmo si no hay errores se volverá a mostrar el menú de opciones. Tenga en cuenta que el tiempo de
carga del grafo dependerá de qué tan denso sea.