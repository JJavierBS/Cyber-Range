import { useState } from "react";
import { InstructorView } from "./views/InstructorView";
import { AttackerView } from "./views/AttackerView";
import { DefenderView } from "./views/DefenderView";

type Role = "instructor" | "attacker" | "defender";

export function App() {
  const [role] = useState<Role>("instructor");

  switch (role) {
    case "instructor":
      return <InstructorView />;
    case "attacker":
      return <AttackerView />;
    case "defender":
      return <DefenderView />;
  }
}
