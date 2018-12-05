# Simple location visualization app

This app was created as an assignment to the course Software Enginneering of Mobile Systems.
It visualizes location data from four different sources:
* walking
* running
* biking
* driving

The data can be filtered using a mean filter. Application is cloud ready and was successfully deployed on [Heroku]("https://heroku.com/").

## Notes
* Application does not support https, so if you want to use it, please switch from https to http.
* Mean filter should be moved from client to server, so that client is as thin as possible and performs only visualization.