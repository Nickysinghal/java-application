import React, { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { adminLogin } from '../../api/loginApi'

const AdminLogin = () => {
    const navi = useNavigate()
    const [email, setEmail] = useState("")
    const [pass, setPass] = useState("")
    

    async function handleLogin(e) {
        e.preventDefault()
        const res = await adminLogin(email, pass)
        if (res === "Login Successful") {
            navi("/admin/dashboard")
        } else {
            console.log("Invalid email or password")
        }
    }

    return (
        <div>
            <h2>Admin Login</h2>
            <form onSubmit={handleLogin}>
                <input type="email" placeholder='Enter Email' onChange={(e) => setEmail(e.target.value)} value={email} />
                <input type="password" placeholder='Enter Password' onChange={(e) => setPass(e.target.value)} value={pass} />
                <button type="submit">Login</button>
            </form>
        </div>
    )
}

export default AdminLogin