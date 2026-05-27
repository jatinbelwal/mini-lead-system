"use client";

export default function TestToolsPage() {

  const resetQuotas = async () => {

    const response = await fetch(
      "https://mini-lead-system.onrender.com/test-tools/reset-quotas",
      {
        method: "POST"
      }
    );

    const data = await response.text();

    alert(data);
  };

  const generateLeads = async () => {

    const response = await fetch(
      "http://localhost:8080/test-tools/generate-leads",
      {
        method: "POST"
      }
    );

    const data = await response.text();

    alert(data);
  };

  return (
    <div
      style={{
        minHeight: "100vh",
        background:
          "linear-gradient(to right, #0f172a, #1e293b)",
        display: "flex",
        justifyContent: "center",
        alignItems: "center",
        padding: "20px"
      }}
    >

      <div
        style={{
          width: "100%",
          maxWidth: "450px",
          background: "white",
          padding: "40px",
          borderRadius: "20px",
          boxShadow: "0 10px 40px rgba(0,0,0,0.3)",
          textAlign: "center"
        }}
      >

        <h1
          style={{
            marginBottom: "35px",
            color: "#0f172a",
            fontSize: "32px"
          }}
        >
          Test Tools
        </h1>

        <button
          onClick={resetQuotas}
          style={buttonStyle}
        >
          Reset Quotas
        </button>

        <button
          onClick={generateLeads}
          style={{
            ...buttonStyle,
            background: "#16a34a"
          }}
        >
          Generate 10 Leads
        </button>

      </div>
    </div>
  );
}

const buttonStyle = {
  width: "100%",
  padding: "15px",
  marginBottom: "18px",
  border: "none",
  borderRadius: "12px",
  background: "#2563eb",
  color: "white",
  fontSize: "16px",
  fontWeight: "bold",
  cursor: "pointer"
};