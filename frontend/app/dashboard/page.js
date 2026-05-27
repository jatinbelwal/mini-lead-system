"use client";

import { useEffect, useState } from "react";

export default function DashboardPage() {

  const [providers, setProviders] = useState([]);

  const fetchDashboard = async () => {

    const response = await fetch(
      "https://mini-lead-system.onrender.com/dashboard"
    );

    const data = await response.json();
    console.log(data);

    setProviders(data);
  };

  useEffect(() => {

    fetchDashboard();

    const interval = setInterval(() => {
      fetchDashboard();
    }, 3000);

    return () => clearInterval(interval);

  }, []);

  return (
    <div
      style={{
        minHeight: "100vh",
        background: "#f1f5f9",
        padding: "40px"
      }}
    >

      <h1
        style={{
          fontSize: "38px",
          marginBottom: "30px",
          color: "#0f172a",
          textAlign: "center"
        }}
      >
        Provider Dashboard
      </h1>

      <div
        style={{
          display: "grid",
          gridTemplateColumns:
            "repeat(auto-fit, minmax(280px, 1fr))",
          gap: "25px"
        }}
      >

        {
          providers.map((provider) => (

            <div
              key={provider.id}
              style={{
                background: "white",
                borderRadius: "20px",
                padding: "25px",
                boxShadow:
                  "0 5px 20px rgba(0,0,0,0.08)"
              }}
            >

              <h2
                style={{
                  color: "#1e293b",
                  marginBottom: "20px"
                }}
              >
                {provider.name}
              </h2>

              <div style={infoStyle}>
                <span>Monthly Quota</span>
                <strong>
                  {provider.monthlyQuota}
                </strong>
              </div>

              <div style={infoStyle}>
                <span>Used Quota</span>
                <strong>
                  {provider.usedQuota}
                </strong>
              </div>

              <div style={infoStyle}>
                <span>Remaining</span>
                <strong>
                  {
                    provider.monthlyQuota
                    - provider.usedQuota
                  }
                </strong>
              </div>

              <div
                style={{
                  marginTop: "20px",
                  height: "12px",
                  background: "#e2e8f0",
                  borderRadius: "10px",
                  overflow: "hidden"
                }}
              >
                <div
                  style={{
                    width: `${
                      (provider.usedQuota /
                        provider.monthlyQuota)
                      * 100
                    }%`,
                    background: "#2563eb",
                    height: "100%"
                  }}
                />
              </div>

            </div>
          ))
        }

      </div>
    </div>
  );
}

const infoStyle = {
  display: "flex",
  justifyContent: "space-between",
  marginBottom: "14px",
  fontSize: "16px"
};