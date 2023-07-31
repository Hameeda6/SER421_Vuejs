<script>
export default {
    data() {
      return {
        // instance variables
      }
   },
   methods: {

  }
}
</script>

<template>
  <div id="content">
    <h1>Tutorial</h1>
    <div id="def">
      <h3>Learning Outcomes:</h3>
    <ul>
      <li>Understand, implement, and run a microservice architecture on your local machine</li>
      <li>Understand the purpose of containers, and be able to containerize implemented microservices in a Docker container</li>
      <li>Understand the purpose of the cloud, and be able to deploy and run docker containers on an AWS server</li>
    </ul>
    </div>
    <p>To follow this tutorial exactly, you will need:</p>
    <ul>
      <li>VSCode (you can use another editor)</li>
      <li>Eclipse (you can use another editor)</li>
      <li>NodeJS v16.17.0</li>
      <li>Java 11.0.13</li>
      <li>Gradle 7.3.3</li>
      <li>Docker 20.10.21</li>
      <li>DockerHub account (free tier) with a private repo</li>
      <li>Spring Tools 4.16.1 (or equivalent spring plugin for your IDE)</li>
      <li>AWS Amazon Linux Instance with docker installed</li>
    </ul>
    <p><span id="boldSpan">Scenario:</span> Imagine that you have the idea of implementing your own online-calculator service! In addition to the math operations your app will provide, you also want to be able to provide a service to send the user a random math fact. One idea for the architecture would be to implement it as a monolith:</p>
    <img src="../../resources/tutorialMonolith.png" alt="Diagram of a monolith architecture for this system">
    <p>This option would have the client interact with one server for both the fact and math service. While this architecture would work, you plan on deploying your application in increments, and adding new math functions that the user can perform over time. This would require for the whole service to be rebooted once a new math function is added to the math service. This would mean that users could not access the random fact functionality when the math service is offline or being updated. The other option is to implement the app in a microservice architecture:</p>
    <img src="../../resources/tutorialMicroservice.png" alt="Diagram of a microservice architecture for this system">
    <p>This option would let the UI/Client interact with both services which are logically independent from each other. This helps decouple the system and in doing so allows each microservice to use their own tech stack that fits the requirements, allows the development team to update each microservice without disturbing the other, and ensures that one microservice crashing would not affect the other microservices running.</p>
    <p>(For this tutorial, we won’t be including interactions to a database for the sake of simplicity)</p>
    <h3>Math Microservice</h3>
    <p>We will be using NodeJS to create a simple Express server to implement our simple math microservice API.</p>
    <p>Go into your desired directory in your terminal and run “npm init”. You will be prompted to fill out some configurations for your project (I chose the entry point as “server.js”, but you can leave it as index.js if desired).</p>
    <p>In terminal after the configurations have been set, run “npm install express”. After this step, we are ready to code!</p>
    <p>Type in the following code into your JavaScript file:</p>
    <code>const express = require('express');<br>
const app = express(); <br>
 
const port = 8888;<br>
 
app.get('/', (req, res) => {<br>
    res.send("IP ADDRESS REACHED");<br>
});<br>
 
app.get('/add', (req, res) => {<br>
    let num1 = parseInt(req.query.num1);<br>
    let num2 = parseInt(req.query.num2);<br>
    let answer = num1 + num2;<br>
    if(!answer){<br>
        res.send("One of the inputs was not an integer!");<br>
    } else {<br>
        res.send("The answer: " + answer);<br>
    }<br>
});<br>
 
app.listen(port, () =>{<br>
    console.log("Server running on port " + port);<br>
});<br>
</code>
  <p>The first line brings in the recently downloaded express library. The second line calls express() to create an application which allows the user to set up the server. The app.get() functions set up an endpoint for GET HTTP requests according to the string passed as the first parameter. We also see that the app.get() function has a callback as a second parameter. For this callback, we use 2 parameters: req, which represents the request from the client, and res, which represents the response to be sent back to the client. Inside the callback for the app.get() function, we are getting num1 and num2 as parameters from the client request. If num1 + num2 results in NaN, then the server responds with a message saying that either num1 or num2 was not an integer. If both num1 and num2 are an integer, then their sum is sent to the client.</p>
  <p>We can also see the app.listen() function which takes in a port number as the first parameter and takes in a callback as the second. In the callback, we are just printing out a message saying that the server is running on the specified port.</p>
  <p>To run the server, enter “node server.js” in the command line. From here, we can go to the browser and enter “localhost:8888/add?num1=6&num2=5” to see what 6 + 5 is:</p>
  <img src="../../resources/localMath1.png" alt="">
  <p>We can also set num1 or num2 to equal something other than an integer:</p>
  <img src="../../resources/localMathBroken.png" alt="">
  <p>We have now completed implementing the math microservice! Now to go on to implementing the random fact microservice.</p>
  <h3>Random Fact Microservice</h3>
  <p>We will be using Java and Spring Boot to implement our simple random fact microservice.</p>
  <p>Go to <a href="https://start.spring.io/">Spring Boot Initializer</a> to download a zipfile of our starter Spring Boot project. Select Gradle under “Project” and “Java” under language. The Spring Boot version can be left as the default selected value. Enter in your desired Group, Artifact, Name, Description, and Package name values under “Project Metadata”. Select jar under “Packaging” and select 11 under “Java” (or choose whatever version of Java you are running). Under “Dependencies”, just choose Spring Web. After all of this, click “Generate” and the zipfile of your starter Spring Boot project will be downloaded. Unzip the folder and open it in your favorite text editor (I will be using Eclipse).</p>
  <p>In the class that contains the main method, add this method:</p>
  <code>
    @GetMapping("/randomfact") <br>
    public String getRandomFact() {<br>
        String[] facts = {<br>
                "The word hundred comes from the old Norse term, hundrath, which actually means 120 and not 100.",<br>
                "In a room of 23 people there's a 50% chance that two people have the same birthday.",<br>
                "Most mathematical symbols weren’t invented until the 16th century. Before that, equations were written in words.",<br>
                "Forty is the only number that is spelt with letters arranged in alphabetical order.",<br>
                " Conversely, one is the only number that is spelt with letters arranged in descending order.",<br>
                "From 0 to 1000, the only number that has the letter a in it is one thousand.",<br>
                "Four is the only number in the English language that is spelt with the same number of letters as the number itself.",<br>
                "Every odd number has an e in it.",<br>
                "Over 2000 years ago, Eratosthenes estimated the Earth's circumference using math, without ever leaving Egypt, and he was accurate to within 2%",<br>
                "Markings on animal bones indicate that humans have been doing math since around 30,000BC."<br>
        };<br>
        String randFact = facts[(int) Math.floor(Math.random() * facts.length)];<br>
        return randFact;<br>
    } <br>
  </code>
  <p>The GetMapping(“/randomfact”) tag specifies an endpoint for GET HTTP requests according to the string passed to it. Here, an array of strings contains random facts (as opposed to retrieving them from a database). Then, a random fact is chosen and sent back to the user.</p>
  <p>(Fun facts from <a href="https://www.whizz.com/en-us/blog/20-cool-facts-math/">this website</a>)</p>
  <p>To run the server, you can either enter “gradle build” and then “gradle run” in the command line or run the code via your IDE. Then, go to “localhost:8080/randomfact” in your browser:</p>
  <img src="../../resources/localFact1.png" alt="">
  <p>Every time the page is refreshed, another random fact will appear in the browser:</p>
  <img src="../../resources/localFact2.png" alt="">
  <p>We have now finished implementing the random joke microservice! Now that both of our microservices run on our local machine, we need to package them into a container with all of their dependencies so that deploying them to the cloud is easy!</p>
  <h3>Containerizing the Math Microservice</h3>
  <p>In order to run our math microservice in a container, we first need to create an image of it. To do this, we must create a new file within the directory of the math microservice called “Dockerfile” with no file extension. Here, you can copy these specifications into your Dockerfile:</p>
  <code>
    FROM node:14-alpine <br>
WORKDIR /usr/src/app <br>
COPY package*.json /usr/src/app/ <br>
RUN npm install <br>
COPY . . <br>
EXPOSE 8888 <br>
CMD ["node", "server.js"] <br>
  </code>
  <p>The first line specifies from which image are we going to build our image off of. In this case, I chose node:14-alpine which contains our node dependency based off of a lightweight version of Linux. Next, “WORKDIR” specifies the file structure within the image. “COPY” specifies what files we will be copying to where in the image (a single dot represents everything in the current directory). Next, “EXPOSE” lets us specify which ports we will be wanting to expose (A docker image has internal ports that can be mapped to external ports once we run the command to run the container/image). Lastly, “CMD” lets us specify what commands should be run to run the microservice.</p>
  <p>(Since our directory for our math microservice has the node_modules/ directory, we can include it in a .dockerignore file which is similar to a .gitignore file.)</p>
  <p>To build your image, run the command “docker build -t [yourUsername]/[yourPrivateDockerRepoName]:[tagName] .”</p>
  <p>Now that the image is built, we can run the image, and we should be able to see it in the browser via the previous link! We can run the image by entering in the command line: “docker run -p [internalPortMapping]:[externalPortMapping] [imageID]”.</p>
  <h3>Containerizing the Random Fact Microservice</h3>
  <p>Similar to the math microservice example, we must also make a Dockerfile in the directory of our spring boot project. Within the Dockerfile, you can copy the following specification:</p>
  <code>
    FROM openjdk:11 <br>
WORKDIR /app <br>
COPY build/libs/demo-0.0.1-SNAPSHOT.jar SpringBootTutorial.jar <br>
EXPOSE 8080 <br>
CMD ["java", "-jar", "/app/SpringBootTutorial.jar"] <br>
  </code>
  <p>This Dockerfile is a little different from the previous one that we have created. This time, we are only copying over a .jar file that is located in the build directory (If that directory doesn’t exist for you, then you need to run “gradle build”. The build directory will show up with the jar above). Also, if your jar is named something differently, then you should specify so in the Dockerfile for  “COPY”. Since we will have the container running a jar, the commands are different as well.</p>
  <p>Regardless, we can build our image by running the command “docker build -t [yourUsername]/[yourPrivateDockerRepoName]:[tagName] .”</p>
  <p>Now that the image is built, we can run the image, and we should be able to see it in the browser via the previous link! We can run the image by entering in the command line: “docker run -p [internalPortMapping]:[externalPortMapping] [imageID]”.</p>
  <h3>Pushing Our Images to a Private DockerHub Repo</h3>
  <p>Now that we have our images, we need to push them to a private (or public, but a private repo is used for this tutorial) repo so that we can download them from our AWS instance. To push an image to your private repo, you can enter this command into your terminal: “docker push [userName]/[repoName]:[imageTag]”. You should be able to see your images like this in your DockerHub repo:</p>
  <img src="../../resources/dockerHub.png" alt="">
  <h3>Pulling and Running The Images on an AWS Instance</h3>
  <p>Now that we have our images in a DockerHub repo, we can pull them to our AWS instance. First we need to log into our docker account on the instance with the command “sudo docker login”. You will be prompted for your credentials. Once logged in, we can pull an image with the command “sudo docker pull [userName]/[repoName]:[imageTag”. Once both images are on the AWS instance, you can confirm that they have been pulled with the command “sudo docker images”. You should see both the Spring Boot and the NodeJS images. To run an image, you can use the command “sudo docker run -d -p [internalPort]:[externalPort] [imageID]”. Once both images are running, you can use a browser to see their output by using the old “localhost” links, but replacing “localhost” with the instance’s public IPv4 address:</p>
  <img src="../../resources/awsFact.png" alt="">
  <img src="../../resources/awsMath.png" alt="">
  <p>Here you can see both images on my AWS instance and the 2 containers that are running them separately and simultaneously:</p>
  <img src="../../resources/awsTerminal.png" alt="">
  <p>Congratulations! You have just implemented a microservice(s) and deployed them on the cloud via Docker!</p>
  </div>
</template>

<style>
#def{
  background-color: #e3e3e3;
}
#boldSpan{
  font-weight: bolder;
  font-size: large;
}
code {
  display: block;
  padding: 15px;
  background-color: rgb(219, 219, 219);
  border: 3px solid rgb(117, 117, 117);
}
</style>