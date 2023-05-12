# recycle-java
This is the java client to use when participating in the Domain Modeling hands-on.

# Getting started
## Starting your server
Start the application with your favorite runner: `./gradlew bootRun`, `./mvnw spring-boot:run` or whatever you see fit

This will start your server locally on port `8080`

If you want a continuous build on code change, you can run these two commands in separate terminals:
- `./gradlew build --continuous`
- `./gradlew bootRun`

## Setting up ngrok
Make sure you have ngrok configured correctly. If unsure, please visit https://dashboard.ngrok.com/get-started/your-authtoken

`ngrok http 8080` should  setup the tunnel. Copy the generated url from the commandline.
You can also visit https://dashboard.ngrok.com/cloud-edge/endpoints to see the endpoints you are exposing.

## Registering on the hands-on server
Go to https://domain-modelling.fly.dev/ and start a session.

Add the url you got from ngrok as a client url when asked, and validate the connection.

You are now ready to start. Follow the instructions for the exercises.
