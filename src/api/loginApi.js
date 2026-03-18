import axios from "axios";
import api from "./api";

const studentLogin = (email,pass) =>{
    try{
         const res = api.post("/student/login",{email,pass});
         return res.data;
    }
   catch(error){
    console.log(error);
    
   }
    
}