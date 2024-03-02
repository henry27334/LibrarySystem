<template>
    <div class="LoginView" style="margin: 20px">
      <el-card class="box-card" style="max-width: 480px; margin: auto;">
        <el-form :model="formSignUp" label-width="150px" style="max-width: 460px">
          <el-form-item label="Phone Number">
            <el-input v-model="formSignUp.phone_number" 
                      placeholder="Enter your phone number" 
                      maxlength="10" 
                      @keypress="checkNumber($event)"
                      show-word-limit>
            </el-input>
          </el-form-item>
          <el-form-item label="Password">
            <el-input v-model="formSignUp.password" placeholder="Enter your password" show-password></el-input>      
          </el-form-item>
          <el-form-item label="Confirm Password">
            <el-input v-model="formSignUp.confirm_password" placeholder="Enter your password Again" show-password></el-input>      
          </el-form-item>
          <el-form-item label="User Name">
            <el-input v-model="formSignUp.username" placeholder="Enter your name here"></el-input>      
          </el-form-item>

          <el-form-item>
            <el-button type="primary" @click="handleSignUp()">
              Create
            </el-button>
            <!-- <el-button @click="resetForm()">Reset</el-button> -->
          </el-form-item>
        </el-form>
      </el-card >
    </div>
  </template>
  
  <script>
    import { inject } from 'vue'
    import { useRouter } from 'vue-router'
    import ax from 'axios'

    export default {
    name: 'SignUpView',
    setup () {
      const lsbackend = inject('lsbackend');
      const router = useRouter()
      const redirect = () => {
        router.push({ name : "login"});
      }

      return { lsbackend, redirect }
    },
    data() {
      return {
        formSignUp: {
          phone_number: '',
          password: '',
          confirm_password: '',
          username: ''
        }
      }
    },
    methods: {
      handleSignUp () {
        let phonenumber = this.formSignUp.phone_number;
        let password = this.formSignUp.password;
        let confirm_password = this.formSignUp.confirm_password;
        let username = this.formSignUp.username;
        let lsbackend = this.lsbackend;

        if (phonenumber === '' | password === "" | username === "") {
          alert("Field should be filled.");
          return;
        }

        if (confirm_password !== password){
          alert("Input password is not the same.")
          return;
        }
        
        ax.post( lsbackend + 'user/createUser',
          {
            "phone_number" : phonenumber,
            "password" : password,
            "username" : username,
            "registaration_time" : Date.now(),
            "last_login_time" : ""
          })
          .then((response) => {
            let userId = response.data;
            if (userId != null) {
              alert("Sign up success");
              this.redirect();
            }
            else{
              alert("Sign up fail, please try again");
            }
          })
          .catch(function (error) {
            console.log(error);
          })
          .finally(function () {
            console.log('finally');
          })

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
  