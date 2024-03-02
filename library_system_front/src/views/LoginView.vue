<template>
  <div class="LoginView" style="margin: 20px">
    <el-card class="box-card" style="max-width: 480px; margin: auto;">
      <el-form :model="formSignIn" label-width="150px" style="max-width: 460px; margin: auto;">
        <el-form-item label="Phone Number">
          <el-input v-model="formSignIn.phone_number" 
                    placeholder="Phone Number" 
                    maxlength="10" 
                    @keypress="checkNumber($event)"
                    show-word-limit></el-input>
        </el-form-item>
        <el-form-item label="Password">
          <el-input v-model="formSignIn.password" placeholder="Password" show-password></el-input>      
        </el-form-item>
        <el-form-item>
          <el-button type="primary" @click="handleSignIn()">
            Login
          </el-button>
        </el-form-item>
      </el-form>
    </el-card>
  </div>
</template>

<script>
  import { inject } from 'vue'
  import { useRouter } from 'vue-router'
  import ax from 'axios'

  export default {
  name: 'LoginView',
  setup() {
    const lsbackend = inject('lsbackend');
    const router = useRouter()

    const redirect = () => {
      router.push({ name : "booklist"})
            .then(() => { router.go(0) });
    }

    return { lsbackend, redirect }
  },
  data() {
    return {
      formSignIn: {
        phone_number: '',
        password: '',
      }
    }
  },
  methods: {
    handleSignIn () {
      let phonenumber = this.formSignIn.phone_number;
      let password = this.formSignIn.password;
      let lsbackend = this.lsbackend;

      ax.post( lsbackend + 'user/login',
        {
          "phone_number" : phonenumber,
          "password" : password,
          "last_login_time" : Date.now()
        }
      )
      .then((response) => {
        let user_id = response.data;
        if (user_id != -1) {
          let d = new Date();
          d.setTime(d.getTime() + 1 * 24 * 60 * 60 * 1000);
          let expires = "expires=" + d.toUTCString();
          document.cookie = "userId=" + user_id + ";" + expires + ";path=/";
          alert('Login Success!');
          this.redirect();
          return true;
        }
        else {
          alert('Login fail');
        }
      })
      .catch(function (error) {
        console.log(error);

      })
      return false;
    },
    checkNumber(event){
        event = (event) ? event : window.event;
        var charCode = (event.which) ? event.which : event.keyCode;
        if ((charCode > 31 && (charCode < 48 || charCode > 57))) {
          event.preventDefault();
        } else {
          return true;
        }
    },
  }
}
</script>
