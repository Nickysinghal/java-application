import React, { useState } from 'react'

const StudentLogin = () => {

    const [email, setEmail] = useState("");
    const [pass, setPass] = useState("");

  return (
    <div>
      <form onSubmit={()=>{}}>
        <input type="email" name="email" onChange={(e)=>{setEmail(e.target.value)}}/>
        <input type="password" name="pass" id="" onChange={(e)=>{setPass(e.target.value)}}/>
        <button type="submit">Login now</button>
      </form>
    </div>
  )
}

export default StudentLogin
