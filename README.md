# room-finder-backend

{
	"info": {
		"_postman_id": "86720fde-d912-4597-84fc-45f5f95f0fb6",
		"name": "room-finder",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
	},
	"item": [
		{
			"name": "http://localhost:8080/api/v1/bookings/2020-02-02",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"auth": {
					"type": "noauth"
				},
				"method": "GET",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n\t\"roomName\":\"Office 2\",\n\t\"capacity\": 1\n}"
				},
				"url": {
					"raw": "http://localhost:8080/api/v1/bookings/2020-02-02",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"v1",
						"bookings",
						"2020-02-02"
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/api/v1/bookings/",
			"request": {
				"auth": {
					"type": "noauth"
				},
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n\t\"roomId\":\"6032926cb8e50823cd668374\",\n\t\"bookDate\":\"2020-02-02\",\n\t\"userName\":\"sagar\"\n}"
				},
				"url": {
					"raw": "http://localhost:8080/api/v1/bookings/",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"v1",
						"bookings",
						""
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/api/v1/bookings/2020-02-02",
			"protocolProfileBehavior": {
				"disableBodyPruning": true
			},
			"request": {
				"auth": {
					"type": "noauth"
				},
				"method": "GET",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n\t\"roomName\":\"Office 2\",\n\t\"capacity\": 1\n}"
				},
				"url": {
					"raw": "http://localhost:8080/api/v1/bookings/2020-02-02",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"v1",
						"bookings",
						"2020-02-02"
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/api/v1/room/",
			"request": {
				"auth": {
					"type": "noauth"
				},
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n\t\"roomName\":\"Office 3\",\n\t\"capacity\": 2\n}"
				},
				"url": {
					"raw": "http://localhost:8080/api/v1/room/",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"v1",
						"room",
						""
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/api/v1/bookings/6032841cbface1294329f253",
			"request": {
				"auth": {
					"type": "noauth"
				},
				"method": "DELETE",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n\t\"roomName\":\"Office 2\",\n\t\"capacity\": 1\n}"
				},
				"url": {
					"raw": "http://localhost:8080/api/v1/bookings/6032841cbface1294329f253",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"v1",
						"bookings",
						"6032841cbface1294329f253"
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/api/v1/room/60327eb6d301476145d506e0",
			"request": {
				"auth": {
					"type": "noauth"
				},
				"method": "DELETE",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n\t\"roomName\":\"Office 2\",\n\t\"capacity\": 1\n}"
				},
				"url": {
					"raw": "http://localhost:8080/api/v1/room/60327eb6d301476145d506e0",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"v1",
						"room",
						"60327eb6d301476145d506e0"
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/api/v1/auth/login",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n\t\"userName\":\"sagar\",\n\t\"password\":\"123456\"\n}"
				},
				"url": {
					"raw": "http://localhost:8080/api/v1/auth/login",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"v1",
						"auth",
						"login"
					]
				}
			},
			"response": []
		},
		{
			"name": "http://localhost:8080/api/v1/auth/signUp",
			"request": {
				"method": "POST",
				"header": [
					{
						"key": "Content-Type",
						"name": "Content-Type",
						"value": "application/json",
						"type": "text"
					}
				],
				"body": {
					"mode": "raw",
					"raw": "{\n\t\"userName\":\"sagar\",\n\t\"password\":\"123456\"\n}"
				},
				"url": {
					"raw": "http://localhost:8080/api/v1/auth/signUp",
					"protocol": "http",
					"host": [
						"localhost"
					],
					"port": "8080",
					"path": [
						"api",
						"v1",
						"auth",
						"signUp"
					]
				}
			},
			"response": []
		}
	]
}
