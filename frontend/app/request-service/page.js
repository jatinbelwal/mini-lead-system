"use client";

import { useState } from "react";

export default function RequestServicePage() {

  const [form, setForm] = useState({
    name: "",
    phone: "",
    city: "",
    serviceType: "Service 1",
    description: ""
  });

  const [loading, setLoading] = useState(false);

  const handleSubmit = async (e) => {

    e.preventDefault();

    setLoading(true);

    try {

      const response = await fetch(
        "https://mini-lead-system.onrender.com/api/lead",
        {
          method: "POST",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify(form)
        }
      );

      const data = await response.text();

      alert(data);

      setForm({
        name: "",
        phone: "",
        city: "",
        serviceType: "Service 1",
        description: ""
      });

    } catch (error) {

      console.error(error);
      alert("Something went wrong");
    }

    setLoading(false);
  };

  return (
    <div
      style={{
        minHeight: "100vh",
        background: "linear-gradient(to right, #0f172a, #1e293b)",
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        padding: "20px"
      }}
    >

      <div
        style={{
          width: "100%",
          maxWidth: "550px",
          background: "white",
          padding: "35px",
          borderRadius: "20px",
          boxShadow: "0 10px 40px rgba(0,0,0,0.3)"
        }}
      >

        <h1
          style={{
            textAlign: "center",
            marginBottom: "30px",
            color: "#0f172a",
            fontSize: "32px"
          }}
        >
          Request Service
        </h1>

        <form onSubmit={handleSubmit}>

          <input
            value={form.name}
            placeholder="Full Name"
            onChange={(e) =>
              setForm({ ...form, name: e.target.value })
            }
            style={inputStyle}
          />

          <input
            value={form.phone}
            placeholder="Phone Number"
            onChange={(e) =>
              setForm({ ...form, phone: e.target.value })
            }
            style={inputStyle}
          />

          <input
            value={form.city}
            placeholder="City"
            onChange={(e) =>
              setForm({ ...form, city: e.target.value })
            }
            style={inputStyle}
          />

          <select
            value={form.serviceType}
            onChange={(e) =>
              setForm({
                ...form,
                serviceType: e.target.value
              })
            }
            style={inputStyle}
          >
            <option>Service 1</option>
            <option>Service 2</option>
            <option>Service 3</option>
          </select>

          <textarea
            rows={5}
            value={form.description}
            placeholder="Describe your issue"
            onChange={(e) =>
              setForm({
                ...form,
                description: e.target.value
              })
            }
            style={{
              ...inputStyle,
              resize: "none"
            }}
          />

          <button
            type="submit"
            disabled={loading}
            style={{
              width: "100%",
              padding: "15px",
              border: "none",
              borderRadius: "12px",
              background: "#2563eb",
              color: "white",
              fontSize: "17px",
              fontWeight: "bold",
              cursor: "pointer",
              marginTop: "10px"
            }}
          >
            {
              loading
                ? "Submitting..."
                : "Submit Request"
            }
          </button>

        </form>
      </div>
    </div>
  );
}

const inputStyle = {
  width: "100%",
  padding: "14px",
  marginBottom: "18px",
  borderRadius: "10px",
  border: "1px solid #cbd5e1",
  fontSize: "15px",
  outline: "none"
};