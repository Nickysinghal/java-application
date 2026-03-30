import React, { useState } from 'react'
import studentLogin from '../../api/loginApi';
import { useNavigate } from 'react-router-dom';

const StudentLogin = () => {

  const navi = useNavigate();
  const [email, setEmail] = useState("");
  const [pass, setPass] = useState("");
  const [id, setId] = useState(0)

  function redirectTodashboard() {
    navi("/student/dashboard");
  }

  async function handleLogin() {
    const res = await studentLogin(id, email, pass);
    if (res == "Login Successful") {
      //redirect to dashboard
      redirectTodashboard();

    } else {
      //show login error
      // redirectTodashboard();
    }
  }
  return (
    <div>
      <form onSubmit={() => { handleLogin() }}>
        <input type="text" name="id" placeholder='Enter name' onChange={(e) => { setId(e.target.value) }} />
        <input type="email" name="email" placeholder='Enter Email' onChange={(e) => { setEmail(e.target.value) }} />
        <input type="password" name="pass" placeholder='Enter password' id="" onChange={(e) => { setPass(e.target.value) }} />
        <button type="submit">Login now</button>
      </form>
    </div>
  )
}

export default StudentLogin
