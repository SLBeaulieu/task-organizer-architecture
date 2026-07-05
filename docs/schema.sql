-- ====================================================================
-- SYSTEM ARCHITECTURE BLUEPRINT: SHIFT-OPTIMIZED TASK ORGANIZER
-- Core Feature: Custom Shift Profiles & Bi-Weekly (Every Other Week) Loops
-- ====================================================================

-- 1. SHIFT PROFILES TABLE
-- Defines the boundaries of a user's working/waking day (1st, 2nd, 3rd shift).
-- This solves the "midnight boundary" problem for night shifts.
CREATE TABLE shift_profiles (
    shift_id BIGSERIAL PRIMARY KEY,      -- Auto-incrementing unique identifier
    shift_name VARCHAR(50) NOT NULL,    -- e.g., '3rd Shift' or 'Custom Study'
    start_time TIME NOT NULL,           -- Time the shift begins (e.g., 19:00:00)
    end_time TIME NOT NULL              -- Time the shift ends (e.g., 07:00:00)
);

-- 2. TASKS TABLE
-- Tracks individual items mapped against shift timelines and custom loops.
CREATE TABLE tasks (
    task_id BIGSERIAL PRIMARY KEY,        -- Unique identifier for the action item
    task VARCHAR(255) NOT NULL,          -- Description of the task
    status VARCHAR(50) NOT NULL DEFAULT 'TODO', -- Current state (TODO, IN_PROGRESS)
    
    -- Foreign Key: Links this task to a specific shift profile row.
    -- ON DELETE SET NULL ensures if a shift is deleted, your tasks aren't erased.
    shift_id BIGINT REFERENCES shift_profiles(shift_id) ON DELETE SET NULL,
    
    is_recurring BOOLEAN NOT NULL DEFAULT FALSE, -- TRUE if the task loops
    frequency VARCHAR(50) NULL,                  -- DAILY, WEEKLY, or MONTHLY
    interval_weeks INTEGER NOT NULL DEFAULT 1,   -- Set to 2 for "Every Other Week"
    recurrence_days VARCHAR(100) NULL,           -- Specific days (e.g., 'MON,TUE')
    day_of_month INTEGER NULL                    -- Used for monthly rules (e.g., 15)
);

-- ====================================================================
-- EXPECTED COMMUNICATION CONTRACT (API PAYLOAD EXAMPLE)
-- When the UI asks to create an "Every Other Monday & Tuesday" task on Shift #3,
-- the network package matches this structure:
--
-- {
--   "task": "Night Shift Core Block / Coding Session",
--   "status": "TODO",
--   "shiftId": 3,
--   "isRecurring": true,
--   "frequency": "WEEKLY",
--   "intervalWeeks": 2,
--   "recurrenceDays": "MON,TUE"
-- }
-- ====================================================================
