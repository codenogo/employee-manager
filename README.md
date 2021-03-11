# Employee Manager(Challenge)

Employee manager is a basic feature that onboards and updates new employee details

## Installation
Run the following command in the root directory of the project to package it
```bash
$ mvn clean package
```

Now build the docker image by typing the following command

```bash
docker build -f Dockerfile -t challenge-employee-manager .
```

and run the image

```bash
docker run -p 5001:5001 challenge-employee-manager
```


## Swagger

```link
http://localhost:5001/swagger-ui.html#/
```


## License
[MIT](https://choosealicense.com/licenses/mit/)







