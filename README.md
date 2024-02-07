# Laboratorio 2 - Patterns
En el presente laboratorio, exploraremos el uso de Apache Maven en conjunción con el patrón de diseño Factory en el desarrollo de software. Maven, una herramienta ampliamente adoptada en el ámbito del desarrollo de proyectos Java, se destaca por su capacidad para gestionar eficientemente la estructura y las dependencias de un proyecto. Por otro lado, se evidenciará la imprtancia de los patrones de diseño para el desarrollo de Software limpio y de alta calidad, mediante la implementación del patrón Factory. 

## Maven
### ¿Cuál es la mayor utilidad?
Su mayor utilidad la ofrece al funcionar como una herramienta para construir y manejar procesos basados en Java. Realizando el proceso de construcción sencillo y uniforme, proveyendo información de calidad en el proyecto y alentando mejores prácticas de desarrollo.

### Fases de Maven
Las fases de maven son:
* Validate
* Compile
* Test
* Package
* Integration-test
* Verify
* Install
* Deploy
* Clean
* Site

### Ciclos de vide de construcción
El ciclo de vida de la construcción en Maven es una secuencia de fases bien definida que define el orden en el que se ejecutarán los objetivos.
Maven tiene los siguientes tres ciclos de vida estándar:

* clean
* predeterminado (o construir)
* site

### ¿Para qué sirven los plugins?
Los plugins se utilizan para realizar tareas específicas en el proceso de construcción, como compilar, empaquetar, desplegar, entre otros y se pueden configurar en el archivo pom.xml del proyecto donde sus objetivos se pueden invocar por línea de comandos

### ¿Qué es y para qué sirve el repositorio central de maven?
El repositorio central de Maven es un repositorio listo para usar en red que provee acceso a muchas versiones de diferentes proyectos Open Source en Java, de Apache y otras organizaciones y desarrolladores. Este repositorio permite descargar plugins dinámicamente y proporciona soporte para obtener archivos del repositorio, así como para subir artefactos al repositorio al final de la construcción de la aplicación, dejándolos al acceso de todos los usuarios

## Ejercicio de las figuras
### Crear un proyecto con Maven
Para crear el proyecto con arquetipos es necesario utilizar el comando *"mvn archetype:generate"* en conjunto con los detalles del proyecto tales como groupId, artifactId, version, etc.

![img_2](https://github.com/alexandrac1420/CVDS_Lab-2_Cortes_Rojas_Vasquez/assets/138069735/7d230dd0-96ff-497a-b4ea-1b7c5e21b191)


### Ajustar algunas configuracines en el proyecto
Para cambiar la versión del compilador de Java es necesario agregar la sección properties en el archivo pom.xml

![img_3](https://github.com/alexandrac1420/CVDS_Lab-2_Cortes_Rojas_Vasquez/assets/138069735/fb216b47-ccac-4034-a4fc-f00385208e1c)


### Compilar y ejecutar
El objetivo del parámetro "package" en el comando mvn es empaquetar el proyecto Maven en un archivo JAR, WAR u otro formato de archivo según la configuración del proyecto. Este objetivo se utiliza para compilar el código fuente, ejecutar las pruebas y empaquetar el resultado en un archivo listo para ser distribuido o desplegado.

Además del parámetro "package", otros parámetros que se pueden enviar al comando mvn incluyen:


* -D: Permite definir propiedades del sistema.
* -X: Habilita el modo de depuración.
* -e: Muestra información detallada sobre los errores.
* -P: Activa un perfil específico.
* -pl: Permite construir solo un submódulo específico.
* -am: Construye todos los módulos necesarios para realizar la compilación del proyecto.

Para ejecutar un proyecto Maven desde la línea de comandos y ver la salida al ejecutar con la clase App.java como parámetro en "mainClass", se puede utilizar el complemento exec-maven-plugin. El comando para ejecutar la clase App.java sería similar a:

```shell
mvn exec:java -Dexec.mainClass="paquete.clasePrincipal"
```
En el caso del ejercicio del saludo se ingresó el siguiente comando:
```shell
mvn exec:java  -Dexec.mainClass="edu.eci.cvds.patterns.archetype.App"
```
Y se configuro el archivo pom.xml para que identifique la clase App como la clase principal

![img_1](https://github.com/alexandrac1420/CVDS_Lab-2_Cortes_Rojas_Vasquez/assets/138069735/0681e1e5-9e2c-4ec9-87b1-76deb05d6db2)


Para verificar una correcta implementación se realizaron las siguientes pruebas:
1. Ejecutar la clase sin ingresar parámetros

![img_5](https://github.com/alexandrac1420/CVDS_Lab-2_Cortes_Rojas_Vasquez/assets/138069735/daf42f7b-7803-4ae1-b7a0-d2447707f69e)

   
2. Ejecutar la clase con el parámetro "Samuel"

![img](https://github.com/alexandrac1420/CVDS_Lab-2_Cortes_Rojas_Vasquez/assets/138069735/4f95e246-8ac5-450c-85bd-a3bff8fbbee0)


3. Ejecutar la clase con el parámetro "Samuel Rojas"

![img_4](https://github.com/alexandrac1420/CVDS_Lab-2_Cortes_Rojas_Vasquez/assets/138069735/5e52ca9d-97d3-4173-aae9-3f4b0aae1a91)


### Hacer el esqueleto de la aplicación
Para crear la clase ShapeFactory se implemento un patrón fábrica simple, debido a que esta clase es la encargada de crear instancias de diferentes tipos basandose en un parametro de entrada (type), el cual determinará que tipo de figura regular debe crearse.
```java
package edu.eci.cvds.patterns.shapes;

import edu.eci.cvds.patterns.shapes.concrete.*;

public class ShapeFactory {

    public static Shape create(RegularShapeType type) {
        switch (type) {
            case Triangle:
                return new Triangle();
            case Quadrilateral:
                return new Quadrilateral();
            case Pentagon:
                return new Pentagon();
            case Hexagon:
                return new Hexagon();
            default:
                throw new IllegalArgumentException("Unknown shape type: " + type);
        }
    }
}

```
Por otra parte es necesario volver a modificar el archivo pom.xml para registrar que la clase principal va a ser ShapeMain.

![img_10](https://github.com/alexandrac1420/CVDS_Lab-2_Cortes_Rojas_Vasquez/assets/138069735/e6ae8fb4-f723-4dc3-a97d-3de9754866ab)


Verificando su correcta implementación se realizaron varios casos:
1. Ejecutar la clase ShapeMain sin parámetros
   
   El programa se ejecuta correctamente, sin embargo envia un mensaje diciendo que es necesario ingresar un parámetro.

![img_6](https://github.com/alexandrac1420/CVDS_Lab-2_Cortes_Rojas_Vasquez/assets/138069735/d82a6f9d-7639-493c-b6bf-a3c4c31ac516)


2. Ejecutar la clase ShapeMain con el parámetro qwerty
   
   El programa se ejecuta correctamente, sin embargo envia un mensaje diciendo que el parámetro ingresado no es válido como una figura regular debido a que no hace parte de la lista de figuras planteadas.

![img_7](https://github.com/alexandrac1420/CVDS_Lab-2_Cortes_Rojas_Vasquez/assets/138069735/54cf3781-a525-42f7-990f-b071435216d6)


3. Ejecutar la clase ShapeMain con el parámetro pentagon
   
   El programa se ejecuta correctamente, sin embargo envia un mensaje diciendo que el parámetro ingresado no es válido como una figura regular, esto se debe a que no se escribió el nombre con la primera letra en mayuscula.

![img_8](https://github.com/alexandrac1420/CVDS_Lab-2_Cortes_Rojas_Vasquez/assets/138069735/9faf657d-3a04-485b-9cba-a1bc43f47eb2)


4. Ejecutar la clase ShapeMain con el parámetro Hexagon
   
   El programa se ejecuta correctamente y funciona de la manera adecuada.

![img_9](https://github.com/alexandrac1420/CVDS_Lab-2_Cortes_Rojas_Vasquez/assets/138069735/e52ee5fc-1bb3-43b4-9069-a9df40c6426c)


## Construido con
* Java 21.0.1
* Maven 3.9.6
  
## Autores
* __Alexandra Cortes Tovar__
* __Samuel Rojas Yopasa__
* __Juan Sebastián Vásquez Vega__ 
