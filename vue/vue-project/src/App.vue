<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
  <header>
    <div class="wrapper">
      <div id="titleDiv"><h1 id="title">The Cloud, Containers, and Microservices</h1></div>
      <nav>
        <ul>
          <li><RouterLink to="/">History</RouterLink></li>
          <li><RouterLink to="/tutorial">Tutorial</RouterLink></li>
          <li><RouterLink to="/demo">Demo</RouterLink></li>
          <li><RouterLink to="/analysis">Analysis</RouterLink></li>
          <li><RouterLink to="/resources">Resources</RouterLink></li>
        </ul>
      </nav>
    </div>
  </header>
<body>
  <RouterView />
</body>
</template>

<style scoped>
#title{
  font-size: xx-large;
  font-weight: bold;
  color: white;
  margin: auto; 
  width: 960px;
  font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
  align-items: center;
  padding-top: 1em;
}

#titleDiv{
  width: 100%;
  background-color: rgb(0, 102, 255);
  height: 8em;
  margin-left: 200px;
  position: fixed;
  margin-top: 0;
  padding-top: 0;
}

nav{
  margin: 0;
  padding: 0;
  width: 200px;
  background-color: #f1f1f1;
  position: fixed;
  height: 100%;
  overflow: auto;
}

ul{
  list-style-type: none;
}

li{
  margin: 1em;
  font-size: large;
  font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
}
body{
  margin-left: 200px;
  padding-top: 10em;
  padding-left: 10em;
  padding-right: 10em;
}

</style>
