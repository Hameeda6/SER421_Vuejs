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
    <h1>History</h1>
    <p id="def"><span id="boldSpan">The Cloud:</span> On-demand access, via the internet, to computing resources—applications, servers (physical servers and virtual servers), data storage, development tools, networking capabilities, and more—hosted at a remote data center managed by a cloud services provider [1].</p>
    <p>The history of the cloud can be traced back all the way to 1963 when DARPA charged MIT with the task of developing a computer that can be used by 2-3 people at the same time. This idea of having computer resources shared between multiple people lies at the core of what the cloud aims to do. In more recent history, Amazon launched AWS in 2006, and Google launched its Google Docs services in the same year. Soon after, companies such as Microsoft, OpenStack, IBM, Oracle, and Apple, Google, and more started providing their own cloud services which would eventually provide SaaS (Software as a Service), PaaS (Platform as a Service), and Iaas (Infrastructure as a Service). Cloud computing provides an alternative to to on-site IT, and often provides companies with lower IT costs as well as improved agility and scalability since the computing resources they are using are managed by the cloud provider, and the user only needs to pay for what they use [2].</p>
    <p id="def"><span id="boldSpan">Microservices:</span> An approach to developing a single application as a suite of small services, each running in its own process and communicating with lightweight mechanisms, often an HTTP resource API. These services are built around business capabilities and independently deployable by fully automated deployment machinery [3].</p>
    <p>Companies started moving their services and enterprise applications to the cloud, and these applications would often be implemented in a monolithic style - built as a single logical unit. These monolithic applications would often be comprised of a client interface, a server, and a database. Here, the server would often receive requests from the client, perform logic and access or mutate data in the database, and send back relevant information to the client. The server would contain all of the logic for all of the services that it would provide. While this may be an intuitive architecture, any change to any part of the program requires for the entire system to be redeployed which can make scaling difficult as well as change cycles longer and more costly [3].</p>
    <p>These frustrations led to the wide use of the microservice architecture. As opposed to the monolithic architecture, the microservice architecture aims to split up functionality into components or “suites of services” with each microservice being logically isolated from the other. Each microservice can be written in their own language, managed by different teams, deployed independently, and scaled independently. Microservices are able to be decoupled and cohesive at the same time because communication between microservices typically are HTTP / RESTful protocols. The microservice community prefers “smart endpoints” and “dumb pipes” as well as lightweight messaging methods so as to keep message overhead down since users may interact with tens, or maybe more, of microservices per request [3].</p>
    <p id="def"><span id="boldSpan">Container:</span> A container is a standard unit of software that packages up code and all its dependencies so the application runs quickly and reliably from one computing environment to another [4].</p>
    <p>With the wide popularity of of the microservice architecture, companies were finding themselves creating, managing, and deploying tens or hundreds of microservices across possibly several teams. This presented a new challenge of how to consistently deploy and manage all the microservices within the company. The answer to these challenges were containers. Containers allowed developers to package together all of their code with the needed dependencies in a lightweight format that could be run on any machine. This was convenient as it unified the deployment process and reduced the risk of cluttering their cloud servers with several versions of the same software (if one microservice needed Java 8, but another needed Java 11, these versions would be packaged within their own microservice’s respective container, and would not reside on the actual hardware or virtual machine) [4].</p>
    <p>One of the earlier ancestors of the modern container came around 2000, and were FreeBSD “jails” which allowed the system administrator to split the computer system into multiple independent subsystems called jails which shared the same OS kernel. The user can then install applications in one jail without it being accessible from another jail. In 2004, Sun Microsystems released Solaris Containers which split the system into different “zones” that do not need a dedicated CPU or any other physical hardware for that matter besides the required disk space. Similar to FreeBSD jails, each zone could not observe or interact with events in the other zone. The popularity of containers surged, however, when Docker came on the scene in March of 2013. Docker offered containerization along with an ecosystem for managing said containers which was widely taken advantage of to deploy systems based off of the microservice architecture [5].</p>
    <div id="def">
      <h3>Links to Learn More:</h3>
    <ul>
      <li>Microservices: <a href="https://martinfowler.com/articles/microservices.html">Microservices</a></li>
      <li>The Cloud: <a href="https://docs.aws.amazon.com/">AWS</a></li>
      <li>Containers: <a href="https://docs.docker.com/get-started/overview/">Docker</a></li>
    </ul>
    </div>
  </div>
  </template>

<style>
#def{
  background-color: #e3e3e3;
}
.ul{
  list-style-type: none;
}
#boldSpan{
  font-weight: bolder;
  font-size: large;
}
</style>