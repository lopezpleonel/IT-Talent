# it-talent
https://github.com/lopezpleonel/IT-Talent

url para el servicio con el puerto 8080, para el caso que esté configurado con dicho puerto.

POST para agregar los usuarios http://localhost:8080/usuarios/Agregar

request

{
	"name" : "Leonel Lopez",
	"email" : "lopezpleonel@gmail.com",
	"password" : "Leoawerw7",
	"phoneList":[
        {
            "number":"234234",
            "cityCode":"1",
            "countryCode":"57"
	    }
    ]
}
GET para consultar los archivos agregados http://localhost:8080/usuarios/Listar

Response

User [id=c0a8017b-75d0-1788-8175-d0e48dce0003, name=Leonel Lopez, created=16-11-2020 08: 50: 40, modified=16-11-2020 08: 50: 40, lastLogin=16-11-2020 08: 50: 40, token=c0a8017b-75d0-1788-8175-d0e48dce0003, isActive=true
]

GET para consultar los teléfonos agregados http://localhost:8080/telefonos/Listar

Response

[
    {
        "number": "234234",
        "cityCode": "1",
        "countryCode": "57"
    },
    {
        "number": "2342434",
        "cityCode": "1",
        "countryCode": "57"
    }
]

Responder el código de status HTTP adecuado 
● En caso de éxito, retornar el usuario y los siguientes campos: 
○ id: id del usuario (puede ser lo que se genera por el banco de datos, pero sería más deseable un UUID)
○ created: fecha de creación del usuario 
○ modified: fecha de la última actualización de usuario 
○ last_login: del último ingreso (en caso de nuevo usuario, va a coincidir con la fecha de creación) 
○ token: token de acceso de la API (puede ser UUID o JWT) 
○ isactive: Indica si el usuario sigue habilitado dentro del sistema.

Desarrollo: Al crear el usuario muestra los campos descritos en el mensaje de salida

User [id=c0a8017b-75cd-16f0-8175-ce837c46000b, name=Leonel Lopez, created=15-11-2020 21: 45: 24, modified=15-11-2020 21: 45: 24, lastLogin=15-11-2020 21: 45: 24, token=c0a8017b-75cd-16f0-8175-ce837c46000b, isActive=true ]

● En caso que el correo exista en la base de datos, deberá retornar un error "El correo ya registrado".

   Desarrollo: Al insertar valida el campo email y muestra el mensaje de validación si ya existe el correo electrónico

● El correo debe seguir una expresión regular para validar que formato sea el correcto. ( aaaaaaa@dominio.cl )

   Desarrollo: Valida el foramto de correo con la anotación @Email 

● La clave debe seguir una expresión regular para validar que formato sea el correcto. (Una Mayúscula, letras minúsculas, y dos números)

   Desarrollo: Valida con la anotación @Pattern 
   
● Se debe hacer traza de logs dentro del aplicativo.

   Desarrollo: Realiza la traza de los request y response realizados
