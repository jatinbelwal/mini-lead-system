export default function HomePage() {

  return (
    <div
      style={{
        minHeight: "100vh",
        background: "linear-gradient(to right, #0f172a, #1e293b)",
        color: "white",
        display: "flex",
        flexDirection: "column",
        justifyContent: "center",
        alignItems: "center",
        gap: "20px"
      }}
    >

      <h1
        style={{
          fontSize: "48px",
          marginBottom: "20px"
        }}
      >
        Mini Lead System
      </h1>

      <a href="/request-service">
        <button style={buttonStyle}>
          Request Service
        </button>
      </a>

      <a href="/dashboard">
        <button style={buttonStyle}>
          Dashboard
        </button>
      </a>

      <a href="/test-tools">
        <button style={buttonStyle}>
          Test Tools
        </button>
      </a>

    </div>
  );
}

const buttonStyle = {
  padding: "15px 30px",
  border: "none",
  borderRadius: "12px",
  background: "#2563eb",
  color: "white",
  fontSize: "18px",
  cursor: "pointer",
  width: "250px"
};