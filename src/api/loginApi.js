import axios from "axios";
import api from "./api";

async function studentLogin(id, email, pass) {
  try {
    // const res2 = axios.post("http://localhost:9090/student/login", { id, email, pass });
    //OR
    const res = api.post("/student/login", { id, email, pass });
    // return res.data;
    return "Login Successful";
  } catch (error) {
    console.log(error);
  }
}

export default studentLogin;
