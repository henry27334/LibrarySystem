<script>
  import { inject, ref } from 'vue'
  import { useCookies } from "vue3-cookies";
  import ax from 'axios'

  export default{
    setup () {
      const lsbackend = inject('lsbackend');      
      const isLogin = ref(false);
      const { cookies } = useCookies();
      const user_id = cookies.get('userId');

      if ( user_id != -1 ) {
        isLogin.value = true;
      }

      return { user_id, isLogin, lsbackend }
    },
    methods: {
      handleLogout () {
        document.cookie = "userId=" + -1 + ";"
        ax.post(
          this.lsbackend + 'user/logout',
          {
            "user_id": this.user_id,
            "last_login_time": Date.now()
          })
          .then(() => {
            alert("Logout success")
            location.reload();
          })
          .catch((error) => {
            console.log(error)
          })
        
      }
    },
  }
</script>

<template>
  <nav>
    <router-link to="/booklist">Book List</router-link> 
    <span> | </span>
    <div class="logout" v-if="isLogin" @click="handleLogout()">Logout</div>
    <router-link v-if="!isLogin" to="/login">Login</router-link> 
    <span  v-if="!isLogin"> | </span>
    <router-link v-if="!isLogin" to="/signup">Sign Up</router-link>
  </nav>
  <router-view/>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}

.logout {
  display: inline;
  font-weight: bold;
}
</style>
