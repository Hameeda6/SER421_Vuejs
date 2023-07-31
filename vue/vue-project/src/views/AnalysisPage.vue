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
    <h3>Analysis</h3>
    <p>Deploying the containers in the cloud ignores all the hassle associated with the infrastructure, 
maintenance and utility management for the servers ; reduces the cost indeed. Cloud based 
applications usually use only a fraction of cost of locally installed software and the user 
have the advantage of paying for only the server time or space we use. The data or information
 stored The cloud has less possibilities of stealing the information compared to the physical
 systems. In addition, we can expect a 100% reliability as the data is stored across multiple servers and 
even if one fails, there would be other servers that come in need. All these prove that cloud 
provides Security and reliability , and thus proves a strong point to shift to cloud servers.
 There is one major drawback to this, cloud servers run on internet and so if the
 the internet is down, we can't access or do anything with the cloud[6].
</p><br>
    <p>Microservices are themselves, each individual service having its own processes. These are 
independent from each other.
Microservices are smaller services and can be deployed more quickly than the traditional ones.
  If one microservice fails, the other ones function normally as these ones are independent
 of each other. By dividing the application into smaller units and services, the changes
 can be made more quickly and with less risk.
</p><br>
    <p>When an application is too large, it becomes difficult to make changes and thus having small
microservices can respond to the changes faster and can be deployed independently. 
As each microservice is independent and isolated from each other, it is an easier
maintanence and changes are made to individual ones and thus avoid errors to the maximum.
But still it comes with high complexity and it would be difficult to find errors when occured. 
</p><br>
<p>As it is independent, the communication between the microservices would be a little 
difficult and the network traffic increases. Each microservices differ from each other as they 
use different technology stacks and it would be a great challenge when it comes to sharing the 
code between each microservices[7].  
</p><br>
<p>The containers have all the elements and are software packages to run in any environment. 
The main advantage is it is easy to deploy in cloud platforms and they virtualise the
 operating system. They are far more lightweight and share the OS kernel. It is more
 scalable and allows to scale a particular function without impacting the entire application [8].
</p><br>

<p>Containers are highly portable as it wraps up the microservices and it's easy to deport
across the cloud environments i.e. public, private and hybrid cloud. The containers share 
dependencies having operating systems and the libraries which leads to effective 
resource allocations. Here the main problem is it runs on only one operating system . 
</p><br>

<p>We have used the docker container and as it is completely
isolated from each other , it gives us a complete control of traffic flow. Another main
advantage is the usage of the container images where just created one and use the same
created images at every step of the deployment process. This speeds up the time taken
 from build to production. But one major limitation is that if the application 
is can run in linux and inside a docker container, then it cannot run in 
other environments like windows[9].
</p><br>

</template>

<style>
</style>