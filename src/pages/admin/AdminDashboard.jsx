import React, { useEffect, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import api from '../../api/api'

const AdminDashboard = () => {
    const navi = useNavigate()
    const [students, setStudents] = useState([])

    useEffect(() => {
        async function fetchStudents() {
            try {
                const res = await api.get("/admin/students")
                setStudents(res.data)
            } catch (error) {
                console.log(error)
            }
        }
        fetchStudents()
    }, [])

    function handleLogout() {
        navi("/admin/login")
    }

    return (
        <div>
            <h2>Admin Dashboard</h2>
            <button onClick={handleLogout}>Logout</button>

            <h3>Student Attendance</h3>
            <table>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Attendance</th>
                    </tr>
                </thead>
                <tbody>
                    {students.map((s) => (
                        <tr key={s.id}>
                            <td>{s.id}</td>
                            <td>{s.name}</td>
                            <td>{s.email}</td>
                            <td>{s.attendance}%</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    )
}

export default AdminDashboard